(ns technetium.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[technetium started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[technetium has shut down successfully]=-"))
   :middleware identity})
