
# Simple Chain folder structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Steps to run the project

1. Compile using:

    ```shell
    javac -d bin src/*.java
    ```

1. Run using:

    ```shell
    java -cp bin SimpleChain
    ```

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
