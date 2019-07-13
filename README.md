# paren-particles: TechBookFest 7 circle cut

It's our circle cut for TechBookFest7 written in Clojure.

![paren-particles](paren-particles.gif)

## Prerequisites

- Java 8
- [Leiningen](https://leiningen.org/)

## Usage

- command line

```sh
$ lein run
```

or

```sh
$ lein uberjar
$ java -jar target/techbookfest7-circlecut.jar
```

- Emacs

Run cider, open `src/techbookfest7_circlecut/core.clj` and press `C-c C-k` to evaluate the file.

- REPL

```clj
user=> (require 'techbookfest7-circlecut.core)
```

## Author

- paren-holic

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
