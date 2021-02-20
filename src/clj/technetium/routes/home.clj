(ns technetium.routes.home
  (:require
   [technetium.layout :as layout]
   [technetium.model.game :as game]
   [clojure.java.io :as io]
   [clojure.data.json :as json]
   [technetium.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn game [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/write-str (game/get-game))})

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]
   ["/game" {:get game}]])

