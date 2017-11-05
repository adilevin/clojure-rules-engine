# clojure-rules-engine
A very small demonstration of a tiny macro-based DSL in clojure for defining rules

# How to use

## Prerequisites

1. Install [Clojure](https://clojure.org/guides/getting_started)
1. Install [Leiningen](https://leiningen.org/)

## Run the application

1. Go to `app` under the project folder
1. type

       lein run

1. You should get the output

        Running the following rules:
           if age > 100 then reject
           if weight < 30 then accept
           if height >= 180 then accept

        Testing the following person:
           {:age 80, :weight 15, :height 200}

        Result:
          Decision:  accept
          Reason:  if weight < 30 then accept
