# Scrabble Challenge - this time in Java!

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#built-with">Built With</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#problem-statements">Problem Statements</a></li>
    <li><a href="#project-review-and-roadmap">Project Review and Roadmap</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

---

## About The Project

This project was the third technical challenge of the Digital Futures Academy programme and was originally undertaken
between July 7th and 8th 2022.

The project was to produce a program, using `Java`, that could score scrabble words. Full details of the problem
statement and user requirements can be found in the <a href="#problem-statements">Problem Statements</a> section.

A previous Academy piece of work had been to produce a scrabble scoring program using `javascript`. The purpose of this
challenge was to show my ability to work with a statically typed language to produce the same results and ability to
work using Object-Orientated Design principles.

---

## Built With

The language used is `java 8`. Testing uses the `junit` java testing framework. `Intellij` by JetBrains was used as the
IDE.

---

## Getting Started

Clone the repo.

Compiled Java bytecode is provided in the `./target/` folder. It is suggested you recompile project code use your
preferred IDE's tools or `javac` to recompile
the `.java` files provided in `./src/` and `./test/` folders as part of set up. You will also need to install prject
dependencies using your package manager, `Maven` was used in project creation.

Use your IDE to run the tests in the `ScrabbleTest.java` file in `./test`. For Intellij this can be done through
right-click on the `ScrabbleTest` and clicking `Run ScrabbleTest`.

The `Scrabble` class cannot be used directly. If you want to implement then it is necessary to create an instance of the
class.

e.g.

```java

public class ScrabbleRunner {
    public static void main(String[] args) {
        Scrabble scrabble = new Scrabble("Wordtoscore");
        int score = scrabble.score();
    }
}
```

---

## Problem Statements

The third technical challenge of the Digital Futures Academy programme. The project was to produce a Scrabble scoring
program, showing my ability to translate past learning from `Javascript` to `Java 8` and Object-Orientated Design
principles.

- The original requirements can be found in the file [./ChallengeNotes.md](./ChallengeNotes.md).
- This project met the core and extended acceptance criteria. The implementation of the extended acceptance criteria
  makes assumptions for `double` and `triple letter scores`. The
  implementation assumes that the Characters provided are valid, i.e. present in the word. For example, for the
  word `"a"` provided with a `doubleLetterScore[] = { 'a' }` and `tripleLetterScore[] = { 'a' } ` will apply both the
  double and triple letter scores even though this would clearly break the game rules.

---

## Project Review and Roadmap

My key overall learnings from project:

- The syntax and statically typed nature of `java` compared to `javascript` increases the initial knowledge required in
  order to start coding simple programs and the code complexity.
- Despite the syntactic differences and static typing, the type of thinking and route to solving problems (functions,
  loops, flow control via logic) use the same principles across programming language.
- The static typing forces a greater understanding of what the code is doing before writing. The explicit type
  declaration also
  can support transparency of what code is doing and support code review.

My technical learnings from the project:

- Understanding of `java` as an object based language.
- Implementing functions, loops and flow control within `java`.
- Function overloading (e.g. constructor).
- Importing nad using `java` classes: `Arrays`, `ArrayList`, `HashMap`.

Improvements/additional features that could be included:

- The test spec required that an instance of `Scrabble` be created with a specific word placed within each instance.
  Within a larger program it may make more sense to have the `Scrabble` class be `Static` so that indiviudal instances
  do not have to be created.
- Remove the `ScoreMap` from `Scrabble` and have as its own class. This would allow reuse and better conform with the
  single-responsibility SOLID principle. This separate `ScoreMap` could be `static`.
- I used method overloading for `getLetterForScore` accepting `char` and `Character` parameters. This could be
  simplified as wrapper classes automatically allow primitive values to be passed to them.
- Not accept invalid letters for double and triple letter scores.
- `Scrabble` will accept invalid `lettersWithDoubleScore` and `lettersWithTripleScore` within the constructor arguments.
  If it isn't assured by other aspects of program design that only valid letters will be provided then checks within
  the `Scrabble` constructor could be included to return an error.
- A more complex `key`, `value` pairing could be implemented within the `ScoreMap` to reduce duplication. Though there
  would be a potential trade-off in terms of simplicity and performance.

---

## Acknowledgments

- The `ScrabbleTest` test implementations were provided by Digital Futures.
- Advice and guidance was provided by Digital Futures Academy Trainers Ed Wright and Lucas Chagas at various points
  throughout the project.