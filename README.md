# Technetium

[Technetium][1] is a chemical element with the symbol Tc and atomic number 43. 

[1]: https://en.wikipedia.org/wiki/Technetium

It is the lightest element whose isotopes are all radioactive.

This is a game where the 'pilot' must navigate an asteroid field containing
several dangerously radioactive asteroid 'mines' and 'mark' them based on
the radiation levels of the surrounding asteroids.

## Prerequisites

You will need [Leiningen][2] 2.0 or above installed.

[2]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein run 

## API (TBD)

Simple 'GETful' API

`GET /new-game` Resets game and returns state game

`GET /game` Returns current state of game

`GET /game?x=0&y=0&z=0` Returns current state of game after selecting asteroid at (x, y, z)

## Deployment

Currently deployed to Heroku

[https://crojure-technetium.herokuapp.com/][3]

[3]: https://crojure-technetium.herokuapp.com/

### Leiningen

Run tests
`lein test`

Check test coverage (via Cloverage plugin)
`lein cloverage`

```
|-------------------------------+---------+---------|
|                     Namespace | % Forms | % Lines |
|-------------------------------+---------+---------|
|             technetium.config |   71.15 |  100.00 |
|               technetium.core |   16.99 |   28.57 |
|     technetium.dev-middleware |  100.00 |  100.00 |
|                technetium.env |   19.15 |   66.67 |
|            technetium.handler |   70.19 |   90.00 |
|             technetium.layout |   88.52 |  100.00 |
|         technetium.middleware |   59.63 |   92.31 |
| technetium.middleware.formats |  100.00 |  100.00 |
|     technetium.model.asteroid |   91.52 |   89.58 |
|         technetium.model.game |   69.43 |   66.67 |
|              technetium.nrepl |    3.19 |   20.00 |
|        technetium.routes.home |   48.39 |   60.00 |
|                          user |   60.00 |   60.00 |
|-------------------------------+---------+---------|
|                     ALL FILES |   57.54 |   71.60 |
|-------------------------------+---------+---------|
```

## Dev

### Clojure format plugin

`lein cljfmt check`

`lein cljfmt fix`

## License

The use and distribution terms for this software are covered by the [Eclipse Public License - v 2.0][4], 
By using this software in any fashion, you are agreeing to be bound by the terms of this license. 
You must not remove this notice, or any other, from this software.

[4]: https://www.eclipse.org/legal/epl-2.0/
Copyright © 2021
