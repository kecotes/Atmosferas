from selenium import webdriver

from selenium.webdriver.common.by import By

import time

driver = webdriver.Chrome()

def test_register():
    go_to_home()
    btn_tab_productos = driver.find_element(By.ID, 'tab-productos')
    btn_tab_productos.click()
    time.sleep(4)
    card_producto = driver.find_element(By.ID, 'card-producto-0')
    card_producto.click()
    time.sleep(2)

def go_to_home():
    url = "http://localhost:8100"
    driver.get(url)
    time.sleep(5)