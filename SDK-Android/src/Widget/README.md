# SDK Android - Widgets

Este ejemplo solo sirve para demostrar que los componentes propios del SDK Android de Smart, no es compatible con los elementos y funcionalidad de un Widget.

Como referencia los elementos permitidos en Widgets para la versión 4.2 de Android son:

 * Layouts:

    * FrameLayout
    * GridLayout
    * LinearLayout
    * RelativeLayout 

 * Widgets:

    * AdapterViewFlipper
    * AnalogClock
    * Button
    * Chronometer
    * GridView
    * ImageButton
    * ImageView
    * ListViewProgressBar
    * StackView
    * TextView
    * ViewFlipper

## Posible alternativa (aun no comprobada):
En teoría existe un servicio que devuelve un JSON con la información completa de la URL de imagen, URL del pixel del clic, etc.
Sería posible realizar un componente compatible con widget, ya sea por ejemplo un **“ImageButton”** que obtenga la funcionalidad de los parámetros del JSON.

