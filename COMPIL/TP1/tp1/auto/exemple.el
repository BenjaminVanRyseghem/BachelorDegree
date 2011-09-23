(TeX-add-style-hook "exemple"
 (lambda ()
    (TeX-add-symbols
     "lemaster"
     "ladate"
     "lasalle")
    (TeX-run-style-hooks
     "geometry"
     "landscape"
     "inputenc"
     "utf8"
     "babel"
     "frenchb"
     "latex2e"
     "art10"
     "article")))

