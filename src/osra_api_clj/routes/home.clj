(ns osra-api-clj.routes.home
  (:require [compojure.core :refer :all]
            [cheshire.core :refer [generate-string]]
            [liberator.core
              :refer [defresource resource request-method-in]]))

(defresource home
  :handle-ok (fn [_] (generate-string "Success"))
  ;;:handle-ok (generate-string "Success")
  :etag "fixed-etag" :available-media-types ["text/json"])

(defresource orphans
  :handle-ok (fn [_] (generate-string [
				      {:osra_number 190003
				      :full_name "Ray Smith"
				      :gender "Male"
				      :status "Active"
				      :priority "Normal"
				      :mother_alive "Yes"
				      :sponsorship "Sponsored"}
				      {:osra_number 160002
				      :full_name "Mrs Peacock"
				      :gender "Female"
				      :status "Active"
				      :priority "High"
				      :mother_alive "No"
				      :sponsorship "Sponsored"}
				      {:osra_number 130001
				      :full_name "Fred Bloggs"
				      :gender "Male"
				      :status "Inactive"
				      :priority "Normal"
				      :mother_alive "Yes"
				      :sponsorship "Unsponsored"}
				      ]))
  :etag "fixed-etag" :available-media-types ["text/json"])

(defroutes home-routes
  (GET "/" request home)
  (GET "/orphans" request orphans))
