# newsletter
Newsletter exercise

To start the server run the command:
> ./gradlew appRun

On the first execution it will download dependencies.

While the server is running to start the demo client run the command:
> ./gradlew runDemoClient

It will create some categories and run the example.
```
> Task :runDemoClient
Listing all categories
science
engineering
software
functional_programming
object_oriented_programming
Listing all books
Programming in Scala
[FP, OOP]
Listing all subscribers
subscriber@email.com
Listing all newsletters
subscriber@email.com
Programming in Scala
[[science, engineering, software, functional_programming], [science, engineering, software, object_oriented_programming]]

```