# SpectrumCodingChallenge

# AEESpringBoot
Download the project from GIT and import to eclise as maven project.
Once project is downloaded. 
Please open SpectrumCodeChallengeApp.java and run the file as java application.
Once application is up and running

To fetch the organization details in descending order by org name, please find below REST API
http://localhost:8080/v1/getOrgInfo

To generate a csv file please find below API url
http://localhost:8080/v1/generateCSV

To fetch organizations by name please find below url
http://localhost:8080/v1/getOrgInfoByName/{orgName}

To fetch organizations by number of releases 
http://localhost:8080/v1/getOrgInfoByRelease/{count}

To fetch organizations based on labor hours
http://localhost:8080/v1/getOrgInfoByTotalHours/{hours}

If you want to fetch the organization names in ascending order then please change the config in OrgComparator
class in ProcessAEEService.java
