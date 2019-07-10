(ns techbookfest7-circlecut.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

;; circle cut size
;; NOTE: delete `draw-logo`
;; (def +width+ 700)
;; (def +height+ 800)

;; README size
(def +width+ 800)
(def +height+ 300)

(defn setup-paren []
  {:x (q/random +width+)
   :y (q/random +height+)
   :size (+ (q/random 100) 25)
   :alpha (q/random 255)
   :angle (q/random q/PI)
   :da (- (q/random 0.2) 0.1)})

(defn update-paren [p]
  {:x (:x p)
   :y (:y p)
   :size (:size p)
   :alpha (:alpha p)
   :angle (+ (:angle p) (:da p))
   :da (:da p)})

(defn draw-paren [p]
  (q/fill 0 0 0 (:alpha p))
  (q/text-font (q/create-font "Noto Serif CJK JP Regular" 30))
  (q/text-align :left)
  (q/text-size (:size p))
  (q/push-matrix)
  (q/translate (+ (:x p) (* (:size p) 0.2))
               (+ (:y p) (* (:size p) 0.2)))
  (q/rotate (:angle p))
  (q/text "(" 0 0)
  (q/pop-matrix))

(defn draw-logo []
  (q/text-font (q/create-font "Noto Serif CJK JP Regular" 30))
  (q/text-align :left)
  (q/text-size 60)
  (q/fill 0 0 255 220)
  (q/text "paren-holic" 460 290)
  (q/fill 100)
  (q/text-size 45)
  (q/text "paren-holic" 500 280)
  (q/stroke 0 0 0 100)
  (q/stroke-weight 1)
  (q/line 0 285 +width+ 285))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  (for [n (range 0 100)] (setup-paren)))

(defn update-state [state]
  (map update-paren state))

(defn draw-state [state]
  (q/background 255)
  (doseq [p state]
    (draw-paren p))
  (draw-logo))

(q/defsketch techbookfest7-circlecut
  :title "paren-particles"
  :size [+width+ +height+]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
