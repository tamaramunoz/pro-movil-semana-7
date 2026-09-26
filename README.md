# Tarea 7: Consumo de APIs y Preferencias de Usuario en Android

Este repositorio contiene la aplicación móvil desarrollada para la Semana 7 de la asignatura **Herramientas de Programación Móvil**.

## Objetivo de la Semana
El objetivo principal de esta unidad fue implementar procesos asíncronos para el consumo de APIs RESTful en Android, la deserialización de respuestas JSON y el manejo de persistencia ligera para la gestión de sesiones de usuario utilizando `SharedPreferences`, además de integrar transiciones visuales modernas en la carga de la aplicación.

## Detalles del Proyecto
* **Lenguaje:** Kotlin.
* **Gestión de Sesión:** Implementación de `SharedPreferences` para simular un proceso de Login/Logout, validando credenciales estáticas y manteniendo la sesión activa (persistencia) incluso si la aplicación es cerrada por completo por el sistema.
* **Consumo de API y Asincronía:** Uso de la clase `AsyncTask` (hilos en segundo plano) para realizar peticiones HTTP GET a la API pública `https://mindicador.cl/api/bitcoin` sin bloquear el hilo principal de la interfaz de usuario.
* **Resultado:** Desarrollo de una aplicación que simula una Billetera Virtual (Virtual Wallet). La aplicación inicia con un **SplashScreen** adaptativo configurado nativamente, seguido de una pantalla de inicio de sesión. Una vez autenticado, el usuario accede a la pantalla principal que le da la bienvenida por su nombre y despliega una lista (`ListView`) con el valor histórico del Bitcoin, obtenida tras deserializar la respuesta JSON de la API. Incluye además un botón funcional para borrar los datos de sesión y salir de forma segura.

## Cómo ejecutar localmente
1. Clonar este repositorio.
2. Abrir la carpeta del proyecto (`tamara_munoz_20260923`) utilizando **Android Studio**.
3. Iniciar un emulador virtual desde el **Device Manager** o conectar un dispositivo móvil físico habilitando la depuración por USB.
4. Presionar el botón **Run** en la barra superior para compilar e instalar la aplicación en el dispositivo (Es requisito indispensable contar con conexión a Internet activa en el emulador/dispositivo para el consumo de la API).
5. Nota para depuración: Para visualizar el comportamiento de las peticiones de red, posibles cierres inesperados o el guardado de las preferencias, puedes utilizar la herramienta **Logcat** o **App Inspection** dentro del entorno de desarrollo.

## Desarrollado por:
- Tamara Muñoz