from selenium import webdriver

from selenium.webdriver.common.by import By

import time

driver = webdriver.Chrome()

def test_register():
    go_to_home()

    obj_perfil = establis_user_perfil()

    btn_tab_productos = driver.find_element(By.ID, 'tab-perfil')
    btn_tab_productos.click()
    time.sleep(4)

    input_nombre = driver.find_element(By.ID, 'input-perfil-nombre')
    input_nombre.send_keys(obj_perfil['nombre'])
    time.sleep(2)

    input_email = driver.find_element(By.ID, 'input-perfil-email')
    input_email.send_keys(obj_perfil['email'])
    time.sleep(2)

    btn_perfil_guardar = driver.find_element(By.ID, 'btn-perfil-guardar')
    btn_perfil_guardar.click()


def go_to_home():
    url = "http://localhost:8100"
    driver.get(url)
    time.sleep(5)

def establis_user_perfil():
    nombre = "Kevin"
    apellido = "Cotes"
    email = "nelson.hernandez-g@uniminuto.edu.co"
    tipoDocumento = "CC"
    documento = "10490000000"
    pais = "Colombia"
    departamento = "Cundinamarca"
    ciudad = "Bogoá DC."
    direccion = "No Registra"