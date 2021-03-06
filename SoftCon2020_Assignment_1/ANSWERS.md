PART 1:
=======
Bulletpoint 1: Architecture
-------

(See vis-ui.png)
![vis-ui](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part1/vis-ui.jpg "vis-ui Architecture")
Explanation in natural Language

First things first: The goal of this program is to provide a skeleton to create an User Interface. Therefore, the program is divided into two parts: "vis-ui\\ui" and "vis-ui\\usl". The "ui"-package provides the actual assets to create the UI, whilest the usl is described as the command line tool. In this bulletpoint, we focused on the "vis-ui\\ui" package, as the actual result output of the program heavily relies on that part. It's to make things easier to understand and to reduce to the essentials. 

In the root of the "vis-ui\\ui" package we find 5 packages and several classes. We state that the classes, especially "VisUI", are like the backbone of "vis-ui", hence you find information like the version number in it. We decided to go further and to represent 5 packages of "com.kotcrab.vis.ui" to grasp the nature of the program.

The package "building" has one abstract class "TableBuilder". Several classes (e.g. "CenteredTableBuilder", "GridTableBuilder", ...) inside of "building" extends this abstract class, and all of them import things of the "utilities" package. Since it is called "utilities", we did not go deeper (for the sake of simplicity). We say, "building" creates the actual boxes inside the final window and is therefore crucial for an user interface like this program from kotcrab.

The next big package on the same level like "building" is "util". "util" has some independent classes but also some that import things from "widget". The name "util" suggests, that it provides utility functions and classes, that create the fundamental basics for the further assets.

The "layout" package has just six independent classes. This package does provide the favourable layout of the final UI. Two of those six packages get imported by the last package, "widget". "Widget" is a huge package, with six subpackages and multiple classes. This package provides the actual widgets for the Interface like a colorpicker, menues, etc. As it goes into the very detail, it is sufficient to know, that "widget" is used by "util" and "layout".

The package "i18n" is not connected to any other class.

To keep it simple, we did not point out every connection to the (third-party) repo com.badlogic.gdx, because a major part of the classes in ui did import things of it. Instead, we just mentiond com.badlogic.gdx in general.

Bulletpoint 2: Callgraph
-------

The most prominent entry point seems to be the Main.java in the usl-package. From there, the first actual function call is the parse() function, which after that spreads rather wide. Therefore, to keep things somewhat clearly arranged, we concentrated on that part. In generall, it takes an input and breaks it up into parts that later are handled by the getJson() function, which is not further elaborated because of "simplicity" of the callgraph.

![callgraph](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part1/Call_graph.png "Visualisation of a Callgraph")

PART 2:
======
We chose the following 6 functions from the USL sourcecode:

1. lexIdentifier in Lexer.java / 127
2. lexIdentifierContent in Lexer.java / 147
3. lexStyleBlock in Lexer.java / 214
4. parseAndLexInclude in Lexer.java / 250
5. removeComments in Lexer.java / 98
6. findBlockEnd in  Parser.java / 223

Flowcharts for functions 1 to 6
-------


1. lexIdentifier in Lexer.java / 127
------
![lexIdentifier](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part2/lexidentifier_final.png)


2. lexIdentifierContent in Lexer.java / 147
------
![lexIdentifierContent](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part2/lexIdentifierContent_final.png)


3. lexStyleBlock in Lexer.java / 214
------
![lexStyleBlock](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part2/data_flow_lexStyleBlock.png)


4. parseAndLexInclude in Lexer.java / 250
------
![parseAndLexInclude](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part2/parseAndLexInclude.png)


5. removeComments in Lexer.java / 98
------
![removeComments(String usl)](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part2/removeComments.png)


6. findBlockEnd in  Parser.java / 223
------
![findBlockEnd()](https://github.com/HuberNicolas/swc-group38/blob/master/SoftCon2020_Assignment_1/Part2/findBlockEnd.png)

For each function, there is a flowchart (.png file) in the Part2 folder.
