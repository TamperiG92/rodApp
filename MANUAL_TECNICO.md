# 1. Identificación

## Portada
* **Nombre del Proyecto:** RodApp (Prototipo/Diseño de Interfaz)
* **Fecha:** Abril 2026

## Ficha Técnica
* **Versión de la interfaz:** 1.0 (Prototipo Inicial)
* **Herramientas de diseño:** Figma / Canva
* **Autores:** Santiago

## Tabla de Contenido
1. [Identificación](#1-identificación)
2. [Marco Conceptual](#2-marco-conceptual)
3. [Arquitectura de Información y Navegación](#3-arquitectura-de-información-y-navegación)
4. [Diseño de Interfaz (UI Kit)](#4-diseño-de-interfaz-ui-kit)
5. [Mockups y Prototipado](#5-mockups-y-prototipado)
6. [Cierre](#6-cierre)

---

# 2. Marco Conceptual

## Introducción
RodApp es una aplicación enfocada en mejorar la experiencia del usuario particular en la gestión, registro de gastos y mantenimiento de su motocicleta. Este documento sirve como un manual técnico concentrado exclusivamente en las directrices de interfaz de usuario (UI), lineamientos estéticos y la ergonomía de navegación.

## Objetivos del Prototipo
* **Validación Visual:** Comprobar la coherencia gráfica, legibilidad y el atractivo estético alineado a la imagen de marca.
* **Flujos de Usuario:** Validar de manera conceptual escenarios como la facilidad de registro de documentos, reportes de tanqueada, gestión del perfil y visualización rápida de alertas críticas.
* **Interacción Sugerida:** Establecer la disposición ideal de botones, tarjetas de información y formularios (UX/UI) para que el acto de registrar un dato sea fluido y natural.

## Alcance Visual
**Nota importante:** El presente manual representa estrictamente el diseño de interfaces, la diagramación y las rutas visuales de comportamiento del producto digital. **No describe la implementación lógica, ni la escritura funcional del código de backend o bases de datos**. Todo comportamiento o transición aquí especificada busca emular un flujo ideal para aprobar antes de una construcción definitiva en código.

---

# 3. Arquitectura de Información y Navegación

## Mapa de Navegación / Flujograma

La disposición estructural ha sido pensada como un árbol jerárquico plano impulsado por un menú de acceso inferior (Bottom Nav) que facilita moverse con el pulgar:

* **1. Inicio de Sistema**
  * 1.1 Splash Screen (Animación y carga del Logo)
  * **2. Autenticación (Onboarding)**
    * 2.1 Pantalla Principal: Login // Registrarse
* **3. Experiencia Principal (Logueado)**
  * **3.A. Dashboard (Pantalla de "Inicio")**
    * 3.A.1 Estado "Vacío" (Sin registros aún - Onboarding)
    * 3.A.2 Estado "Lleno" (Resumen de consumo mensual de gasolina, estado de documentos y botones rápidos).
  * **3.B. Módulo de Tanqueadas**
    * Formulario de Galones, Fecha, Costo.
  * **3.C. Módulo de Alertas/Mantenimiento**
    * Lista de notificaciones (Cambio de aceite, Vencimiento del SOAT o Tecnomecánica).
  * **3.D. Perfil y Vehículo**
    * Datos de Santiago / Mi Moto (Placa, Modelo, Nivel General).

*(Inserta aquí tu imagen/gráfico exportado de tu diagrama de flujo)*
`![Diagrama de Navegación de RodApp](./ruta-a-tu-flujograma.png)`

---

# 4. Diseño de Interfaz (UI Kit)

## Guía de Estilo

### Paleta de Colores
El esquema de colores de RodApp extrae sus fundamentos del logo principal y persigue una estética limpia, confiable e inspirada en temas modernos (dark/light theme adaptativo).
* **Azul Institucional:** `#XXXXXX` *(Sustituye por tu código hex)*  
  *Uso:* Color principal de marca. Aparece en encabezados potentes, elementos activos en el menú y el logo central.
* **Verde de Acción:** `#XXXXXX` *(Sustituye por tu código hex)*  
  *Uso:* Se emplea como indicativo de éxito. Resalta los llamados a la acción, botones principales (Ej. "Guardar", "Registrar Tanqueada") e indicadores de que los documentos o el estado de la gasolina están al día (saludables).
* **Grises de Escala (Fondo / Neutros):** `#XXXXXX a #XXXXXX` *(Sustituye por tus códigos hex)*  
  *Uso:* Se utiliza principalmente en el fondo (Modo Oscuro) y en los contenedores de las tarjetas vacías (Card Views), además de emplearse tonos más claros del gris para el "body text" (texto de cuerpo) buscando evitar el blanco puro y reducir la fatiga en la pantalla.

### Tipografía
Para asegurar máxima legibilidad bajo diferentes condiciones de luminosidad en el entorno de manejo, la tipografía seleccionada carece de distracciones (*Serif*):
* **Fuente Primaria (P. ej. Inter, Roboto o Montserrat):**
  * *H1, H2 (Títulos):* Grosor Bold / Semi-Bold.
  * *Cuerpo (Párrafos, descripciones menores):* Grosor Regular (14sp a 16sp).

### Iconografía
La semántica icónica debe ser universalmente reconocida.
* **Gasolina:** Ícono de surtidor tradicional europeo o medidor de volumen (Fill-up icon).
* **Moto:** Figura bidimensional simplificada de una motocicleta (para "Mi Vehículo").
* **Alertas:** Campana sencilla de notificaciones o señalética de prevención (triángulo).
*(Los pesos de todos los iconos son consistentes, ya sea con trazos redondos o sólidos acordes al diseño de figma).*

---

# 5. Mockups y Prototipado

## Mockups Aplicación Móvil
Las siguientes son capturas maestras del prototipo móvil finalizadas en la mesa de trabajo:

1. **Pantallas Iniciales (Login y Registro)**
   *Interfaces que simplifican el inicio de sesión.*
   `![Mockup Login](./ruta-imagen.png)`
2. **Dashboard de Inicio (Inicio Lleno y Vacío)**
   *Representación del "Hub" principal, destacando el progreso en gasolina o invitando a completar la primera gestión vehicular.*
   `![Mockup Inicio](./ruta-imagen.png)`
3. **Módulo de Tanqueada**
   *Teclado numérico, selección fácil visual y la consolidación exitosa.*
   `![Mockup Tanqueada](./ruta-imagen.png)`
4. **Perfil y Alertas**
   *Organización en lista de documentos e indicadores visuales de vencimiento.*
   `![Mockup Perfiles](./ruta-imagen.png)`

## Mockups Panel Administrativo (Web/Admin)
Módulo opcional de gestión backend; es la representación de una web orientada a escritorio para el monitoreo y gestión (Control por el dueño de la App):
1. **Tablero de Mandos Superior (KPIs):** Listado de gráficas que recogen métricas semanales (Galones subidos a la App, etc.)
2. **Tablas Transaccionales de Usuarios:** Interfaz de datos ordenables mediante DataGrid, usando el esquema verde/gris para destacar usuarios verificados o pendientes.
*(Inserta Imágenes del Dashboard de escritorio si aplica)*
`![Dashboard Admin](./ruta-imagen.png)`

## Descripción de Pantallas (Flujos)
* **Botones Verdes Primarios (Ej. "Ingresar", "Agregar Foto"):** Han sido situados en el área natural del "pulgar", en la mitad inferior de la pantalla, guiando a un clic sin esfuerzo.
* **Tarjetas Modulares (Cards):** Utilizan el fondo gris contrastando sobre un fondo más oscuro que delimita claramente cada bloque de información sin usar líneas duras, un rasgo vital de un *Premium UI*.

---

# 6. Cierre

## Conclusiones
A nivel técnico-visual, las decisiones de prototipado para RodApp satisfacen el requerimiento primordial de la aplicación: una experiencia no intrusiva y veloz enfocada en la movilidad. La distribución guiada por el uso selectivo del Azul (para orientar) y el Verde (para ejecutar/confirmar) construyen una relación de agilidad y confianza con el usuario en rutinas rápidas (por ejemplo: mientras detiene su moto por un lapso breve en una estación de gasolina).

## Marco Legal (Protección de Datos)
Es fundamental mencionar que la plataforma, por su naturaleza, capta y procesa la información de sus usuarios (por ejemplo, Placa, Identidad del piloto, o consumo real). A nivel UI/UX visual esto se solventa incorporando pantallas de consentimiento, de conformidad al cumplimiento de la **Ley Estatutaria 1581 de 2012** (Tratamiento de Datos Personales en Colombia).
* Todos los flujos de "Registro" se acompañarán de un componente o casilla (Checkbox) obligatoria: *"Acepto las políticas de uso y tratamiento de datos."* como evidencia tácita de compromiso con la normatividad de privacidad e información.
