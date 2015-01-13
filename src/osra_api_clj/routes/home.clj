(ns osra-api-clj.routes.home
  (:require [compojure.core :refer :all]
            [cheshire.core :refer [generate-string]]
            [liberator.core
              :refer [defresource resource request-method-in]]))

(defresource home
  :handle-ok (fn [_] (generate-string "Success"))
  ;;:handle-ok (generate-string "Success")
  :etag "fixed-etag" :available-media-types ["text/json"])

(defroutes home-routes
  (GET "/" request home))
