# README #

Project Halvarsson &CO from my view.

### Collaborators ###

Many thanks to Oscar aka
[ANSCH](https://github.com/anschch)
for helping me to improve the project.

## Cloning ##

To clone the repository use [Git](https://git-scm.com).

    $ git clone https://github.com/java1711/halvarsson-markus.git

## Config ##

Username and password are read from `auth.conf` on line 1 and 2
respectively.

### Requirements ###

- Username must be 2-20 characters
- Password must be 8-30 characters

## Running ##

The project should be run as a
[Spring Boot application](https://projects.spring.io/spring-boot/).
Out-of-the-box the application will listen on port `8888` (as it is
configured now), but can be customized by editing the
`application.properties` file.

### Runnable JAR ###

First clone the repository and make sure that
[Maven](https://maven.apache.org/)
is installed, as well as JRE, and then:

    $ cd /path/to/halvarsson-markus
    $ mvn package

If the building succeeds (which it should) you should have a runnable
JAR in the `target`-directory. To run it from the command-line enter:

    $ java -jar TheFile.jar

### Database ###

It's not necessary to setup a database. Because the application is
using the
[H2 database](http://www.h2database.com/html/main.html)
per default.
