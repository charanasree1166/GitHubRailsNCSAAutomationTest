Feature: GET Rails Repo Home Page
  Describe: scenarios of Rails repo home page validated

  # Scenario - GitHub Repository REST API returns all valid repos for page 1
  # API return a response with Http Status code 200 Ok
  # Total number of repo's for first page of rails returned should be <=30
  @RepoSearch
  Scenario: call api.github.com by search/repositories endpoint to fetch repos in the rails topic
    Given User is on the github.com/rails page
    When User searches for a repository name
    Then User should be able to see the repository in the result set

    
  @RailsRepo
  Scenario Outline:
    Given service "/search/repositories?q=topic:ruby+topic:rails" endpoint for github api for rails comprehensive "<scenarioname>" and type "GET"
    When call GET api endpoint via github api: "<githubrepourl>" for rails comprehensive testing
    Then verify api response status code: "<statuscode>" for rails comprehensive testing

    Examples:
      | scenarioname         | githubrepourl                                                       | statuscode
      | SearchRepoTopicRails | https://api.github.com/search/repositories?q=topic:ruby+topic:rails |        200


  @TopLanguages
  Scenario Outline: call api.github.com by search/repositories endpoint to fetch repos in the rails topic
    Given service "/languages" endpoint for github api for language comprehensive "<scenario name>" and type "GET"
    When GET api endpoint via github api: "<githubrepourl>" for rails comprehensive testing
    Then verify api response status code: "<statuscode>" for language comprehensive testing

    Examples:
      | scenarioname    | githubrepourl                                      | statuscode
      | GetTopLanguages | https://api.github.com/repos/rails/rails/languages |        200

