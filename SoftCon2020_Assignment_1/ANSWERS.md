PART 1:
=======
Bulletpoint 1: Architecture
-------

(See vis-ui.jpg)
![vis-ui](https://github.com/HuberNicolas/SoftCon2020_Assignment_1/blob/master/Part1/vis-ui.jpg "vis-ui Architecture")
Explanation in natural Language

First things first: We focused on the "vis-ui\\ui" package, although there was also a "vis-ui\\usl" package. We did this to make things easier to understand and to reduce to the basics. The "ui"-package seems be more important ("usl" - package is described as the command line tool).

In the root of the "vis-ui\\ui" package we find 5 packages and several classes. Theses top classes, especially "VisUI" are not very dependent (just "Locales take use the package "widget"). We state that "VisUI" is like the backbone of "vis-ui", hence you find information like the version number in it. We decided to go further and to represent 5 packages of "com.kotcrab.vis.ui" to grasp the nature of the program.

The package "building" has one abstract class "TableBuilder". Several classes (e.g. "CenteredTableBuilder", "GridTableBuilder", ...) inside of "building" extends this abstract class, and all of them import things of the "utilities" package. Since it is called "utilities", we did not go deeper (for the sake of simplicity). We say, "building" is the most important package, since the building process is crucial for a user interface like this package from kotcrab.

The next big package on the same level like "building" is "util". "util" has some independent classes but also some that imports things from "widget". The name "util" suggests, that it provides utility functions and classes, therefore it is not that important.

The package "i18n" is not connected to any other class.

The "layout" package has just 6 independent classes, of which two of them get imported by the last package, "widget". "widget" hughe package, so that we renounce all the classes and packages. It is sufficient to know, that "widget" is used by "util" and "layout".

To keep it simple, we did not point out every connection to the (third-party) repo com.badlogic.gdx, because a major part of the classes in ui did import things of it. Instead, we just mentiond com.badlogic.gdx in general.

Bulletpoint 2: Callgraph
-------




PART 2:
======
We chose the following 6 functions:

1. lexIdentifier in Lexer.java / 127
2. lexIdentifierContent in Lexer.java / 147
3. lexStyleBlock in Lexer.java / 214
4. parseAndLexInclude in Lexer.java / 250
5. removeComments in Lexer.java / 98
6. findBlockEnd in  Parser.java / 223

Flowcharts for functions 1 to 6
-------
![lexIdentifier](https://github.com/HuberNicolas/SoftCon2020_Assignment_1/blob/master/Part2/lexidentifier_final.png)
![lexIdentifierContent](https://github.com/HuberNicolas/SoftCon2020_Assignment_1/blob/master/Part2/lexIdentifierContent_final.png)
![removeComments(String usl)](https://github.com/HuberNicolas/SoftCon2020_Assignment_1/blob/master/Part2/removeComments.jpg "removeComments flowchart")
![findBlockEnd()](https://github.com/HuberNicolas/SoftCon2020_Assignment_1/blob/master/Part2/findBlockEnd.jpg)

For each function, there is a flowchart (.jpg/.png file) in the Part2 folder.
