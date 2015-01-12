(defproject osra-api-clj "0.1.0-SNAPSHOT"
  :description "implemenation of the osra api in clojure"
  :url "https://github.com/PurityControl/osra-api-clj"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [liberator "0.12.2"]
                 [cheshire "5.4.0"]
                 [org.clojure/java.jdbc "0.3.6"]
                 [postgresql "9.3-1102.jdbc4"]
                 [ring-server "0.3.1"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler osra-api-clj.handler/app
         :init osra-api-clj.handler/init
         :destroy osra-api-clj.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
