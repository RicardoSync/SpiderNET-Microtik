# SpiderNET-MikroTik

SpiderNET-MikroTik es una aplicación desarrollada en **Java** diseñada para la gestión de **WISP (Wireless Internet Service Provider)** o **ISP (Internet Service Provider)**. Permite administrar clientes, pagos, equipos, servicios, MikroTik, y más, integrando herramientas de automatización y control para mejorar la administración del servicio.

## 🚀 Características principales

### 📌 Gestión de Clientes
- Creación y edición de clientes.
- Asignación de paquetes de internet (nombre, precio, velocidad).
- Registro de servicios adicionales como TV analógica/digital, streaming u otros.
- Configuración de días de corte del servicio.
- Asignación de uno o más equipos a un cliente.

### 📌 Administración de Pagos y Recibos
- Registro de pagos de clientes.
- Generación y administración de recibos.

### 📌 Gestión de Equipos
- Registro de equipos al crear un cliente.
- Asignación de equipos sin cliente disponible.
- Edición y eliminación de equipos.
- Filtración de equipos por tipo (Router, Antena, ONU, etc.).

### 📌 Administración de Antenas AP
- Registro de antenas con:
  - Nombre.
  - Modelo.
  - Usuario y contraseña.
  - Dirección IP.

### 📌 Integración con MikroTik
- Registro de MikroTik con:
  - Nombre.
  - Dirección IP.
  - Usuario y contraseña.
- Bloqueo y desbloqueo de clientes.
- Modificación de velocidad.
- Agregar clientes a *Simple Queue* con o sin padre.
- Registro automático de clientes usando **DHCP Server Leases** de MikroTik.

### 📌 Módulo de WhatsApp
- Envío de mensajes **masivos** y **personalizados**.
- Notificaciones **automáticas** para cortes de internet.

## ⚙️ Requisitos
- **Java** (versión recomendada: 11 o superior).
- **Base de datos MySQL**.
- **MikroTik RouterOS** (para integración con red ISP).

## 📦 Instalación
1. Clonar este repositorio:
   ```sh
   git clone https://github.com/RicardoSync/SpiderNET-Microtik.git
   ```
2. Configurar la base de datos en MySQL.
3. Configurar credenciales y ajustes en el archivo de configuración.
4. Ejecutar la aplicación en Java.

## 🛠 Uso
- Acceder a la interfaz gráfica para gestionar clientes, equipos y pagos.
- Configurar y conectar MikroTik para el control de red.
- Utilizar el módulo de WhatsApp para enviar notificaciones.

## 📜 Licencia
Este proyecto está bajo la licencia **MIT**.

---
📧 Para soporte o contribuciones, contacta a: +5214981442266 o richardobedoesc@gmail.com

