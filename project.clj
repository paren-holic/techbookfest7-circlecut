(defproject techbookfest7-circlecut "0.1.0-SNAPSHOT"
  :description "paren-particles: paren-holic's circle cut for TechBookFest7"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [quil "3.0.0"]]
  :main ^:skip-aot techbookfest7-circlecut.core
  :profiles {:uberjar {:aot :all
                       :uberjar-name "techbookfest7-circlecut.jar"}})
