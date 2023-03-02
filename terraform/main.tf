terraform {
  required_providers {
    azurerm = {
      version = "=3.45.0"
    }
  }
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "acdb" {
  location = var.location
  name     = "mkheck-acdb-rg"

  tags = {
    "Terraform" = "true"
  }
}

resource "azurerm_service_plan" "acdb" {
  name                = "mkheck-acdb-plan"
  resource_group_name = azurerm_resource_group.acdb.name
  location            = azurerm_resource_group.acdb.location
  os_type             = "Linux"
  sku_name            = "B1"
}

resource "azurerm_linux_web_app" "acdb" {
  name                = "acdbp"
  resource_group_name = azurerm_resource_group.acdb.name
  location            = azurerm_service_plan.acdb.location
  service_plan_id     = azurerm_service_plan.acdb.id

  https_only = true

  site_config {
    application_stack {
      java_server = "JAVA"
      java_server_version = "17"
      java_version = "17"
    }
  }

  app_settings = {
    #    Here is where you place Azure Webapp/Spring Boot properties to pass into the app
    #    "SPRING_PROFILES_ACTIVE" = "postgres"
    "WEBSITES_PORT" = "8080"
  }
}

# MH: Azure Cosmos DB for PostgreSQL not supported in tf template yet :/
#resource "cosmosdb_" "" {}