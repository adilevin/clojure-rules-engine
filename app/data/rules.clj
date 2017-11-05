(use 'app.core) ;This is needed in order to use the macro -if

[
  (-if age > 100 reject)
  (-if weight < 30 accept)
  (-if height >= 180 accept)
]