package discover.shared.transaction.config.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import discover.shared.transaction.config.lambda.models.AggregationConfig;
import java.io.IOException;
import java.io.InputStream;

public class ReadConfiguration implements RequestHandler<S3EventNotification, Context> {

    private static final String FINAL_BUCKET = "s3txn-nextgen-nvirginia-deliverydevqa";
    private static final String CONFIG_FILE = "configFile";

    //https://stackoverflow.com/questions/36730266/aws-lambda-s3event-deserialization
    //need to use S3EventNotification not S3Event
    public Context handleRequest(S3EventNotification s3Event, Context context) {
        ObjectMapper m = new ObjectMapper();
        String configFile = System.getenv(CONFIG_FILE);

        //if setup in environment.
        if (!StringUtils.isNullOrEmpty(configFile)) {
            AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();        
            S3Object object = s3Client.getObject(
                    new GetObjectRequest(FINAL_BUCKET, configFile));
            try (InputStream objectData = object.getObjectContent()) {
                // Process the objectData stream.
                ObjectMapper objectMapper = new ObjectMapper();
                AggregationConfig config = objectMapper.readValue(objectData, AggregationConfig.class);
                // use config ....
                //context.getLogger().log("retentionPeriod:" + config.getRetentionPeriod());
                context.getLogger().log(objectMapper.writeValueAsString(config));
            } catch (IOException e) {
                context.getLogger().log(String.format("Failed to retrieve %1$s - %2$s", configFile, e.getMessage()));
            }
        }
        return context;
    }
}
