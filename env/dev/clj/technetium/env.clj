(ns technetium.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [technetium.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[technetium started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[technetium has shut down successfully]=-"))
   :middleware wrap-dev})
