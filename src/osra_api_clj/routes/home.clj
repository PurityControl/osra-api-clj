(ns osra-api-clj.routes.home
  (:require [compojure.core :refer :all]
            [liberator.core
              :refer [defresource resource request-method-in]]))

(defresource home
  :handle-ok "Success"
  :etag "fixed-etag" :available-media-types ["text/plain"])

(defroutes home-routes
  (GET "/" request home))
