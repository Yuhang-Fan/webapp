#!/bin/bash

sudo apt update -y
sudo apt upgrade -y

sudo apt install -y mysql-server

sudo systemctl start mysql
sudo systemctl enable mysql

DB_NAME="csye6225"
DB_USER="csye_user"
DB_PASS="securepassword"

sudo mysql -e "CREATE DATABASE ${DB_NAME};"
sudo mysql -e "CREATE USER '${DB_USER}'@'localhost' IDENTIFIED BY '${DB_PASS}';"
sudo mysql -e "GRANT ALL PRIVILEGES ON ${DB_NAME}.* TO '${DB_USER}'@'localhost';"
sudo mysql -e "FLUSH PRIVILEGES;"

APP_GROUP="csye6225_group"
APP_USER="csye6225_user"

sudo groupadd ${APP_GROUP}
sudo useradd -m -g ${APP_GROUP} ${APP_USER}

APP_DIR="/opt/csye6225"
sudo mkdir -p ${APP_DIR}
sudo chown -R ${APP_USER}:${APP_GROUP} ${APP_DIR}

sudo unzip /path/to/app.zip -d ${APP_DIR}

sudo chmod -R 750 ${APP_DIR}

echo "Application setup completed successfully."
