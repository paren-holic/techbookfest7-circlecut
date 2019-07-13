(ns techbookfest7-circlecut.core
  (:gen-class)
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
   :angle (q/random (* 2 q/PI))
   :n (+ 1 (q/floor (/ (* (q/random 3) (q/random 3)) 2)))})

(defn draw-paren [p n]
  (q/fill 0 0 0 (:alpha p))
  (q/text-font (q/create-font "Noto Serif CJK JP Regular" 30))
  (q/text-align :left)
  (q/text-size (:size p))
  (q/push-matrix)
  (q/translate (+ (:x p) (* (:size p) 0.2))
               (+ (:y p) (* (:size p) 0.2)))
  (let [a (:angle p)]
    (q/rotate (q/lerp a (+ a (* (:n p) 2 q/PI)) n)))
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
  {:n 0 :parens (for [n (range 0 100)] (setup-paren))})

(defn update-state [state]
  {:n (+ (:n state) 0.005)
   :parens (:parens state)})

(defn draw-state [state]
  (q/background 255)
  (doseq [p (:parens state)]
    (draw-paren p (:n state)))
  (draw-logo))
  ;; NOTE: uncomment if want to record
  ;; (when (< (:n state) 1)
  ;;   (q/save-frame "paren-particles-#####.png"))

(q/defsketch techbookfest7-circlecut
  :title "paren-particles"
  :size [+width+ +height+]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])

(defn -main [& args])
