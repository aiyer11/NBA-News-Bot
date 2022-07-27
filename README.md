# NBA News Bot
A Twitter Bot that tweets NBA News from ESPN at a scheduled time using AWS Lambda and CloudWatch.

## Prerequisites

- A Twitter Developers Account

- An AWS account (any tier will work)

- A RapidApi Account

- Java

- Maven

- An ide for Java preferably Eclipse or InteliJ (I use Spring Tools Suite)

## Setup
- Pull the repo into your ide and edit the application.properties to include your Twitter API keys and your NBA Latest News API key and host from RapidApi: https://rapidapi.com/savey03/api/nba-latest-news/.

- Right click on the project, hover over Run As and click run configurations.

- Navigate to maven build and in the goals section type in "clean package" and click run.

- Once the jars have been generated in your target folder, go to AWS and create a lambda function that runs on Java. Add your jar with "-aws" in it's name to the lambda and specify the handler as "org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest".

- Test the lambda by providing an empty string as input.

- Navigate to the EventBridge console and click on the "Rules" tab.

- Create a new rule and select the schedule option to specify the schedule for your lambda. Then specify the lambda as your target and create the rule.

- Congrats your twitter bot is now operational and should tweet according to your schedule!

