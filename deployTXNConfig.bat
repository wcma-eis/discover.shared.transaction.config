REM
REM Need to manually configure S3 trigger.
REM

call mvn package

serverless deploy -v --stage devqa --team_name cortex --environment eis-deliverydevqa --configFile config/dh_search.json