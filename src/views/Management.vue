<template>
  <div>
    <h2>Управление парковкой</h2>
    <el-tabs v-model="activeTab" @tab-click="handleTabClick">
      <el-tab-pane label="Места" name="spots">
        <el-table :data="spots" style="width: 100%">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="number" label="Номер места"></el-table-column>
          <el-table-column prop="occupied" label="Занято">
            <template #default="scope">
              <el-tag :type="scope.row.occupied ? 'danger' : 'success'">
                {{ scope.row.occupied ? 'Да' : 'Нет' }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column label="Действия">
            <template #default="scope">
              <el-button size="mini" @click="editSpot(scope.row)">Редактировать</el-button>
              <el-button size="mini" type="danger" @click="deleteSpot(scope.row)">Удалить</el-button>
            </template>
          </el-table-column>
        </el-tabs>
        <el-button type="primary" @click="addSpot">Добавить место</el-button>
      </el-tab-pane>
      <el-tab-pane label="Автомобили" name="cars">
        <el-input v-model="carSearch" placeholder="Поиск по номеру автомобиля" style="width: 300px; margin-bottom: 10px;"></el-input>
        <el-table :data="filteredCars" style="width: 100%">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="licensePlate" label="Номер"></el-table-column>
          <el-table-column prop="owner.name" label="Владелец"></el-table-column>
          <el-table-column label="Действия">
            <template #default="scope">
              <el-button size="mini" @click="editCar(scope.row)">Редактировать</el-button>
              <el-button size="mini" type="danger" @click="deleteCar(scope.row)">Удалить</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-button type="primary" @click="addCar">Добавить автомобиль</el-button>
      </el-tab-pane>
      <el-tab-pane label="Владельцы" name="owners">
        <el-input v-model="ownerSearch" placeholder="Поиск по ФИО" style="width: 300px; margin-bottom: 10px;"></el-input>
        <el-table :data="filteredOwners" style="width: 100%">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="name" label="ФИО"></el-table-column>
          <el-table-column prop="phone" label="Телефон"></el-table-column>
          <el-table-column label="Действия">
            <template #default="scope">
              <el-button size="mini" @click="editOwner(scope.row)">Редактировать</el-button>
              <el-button size="mini" type="danger" @click="deleteOwner(scope.row)">Удалить</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-button type="primary" @click="addOwner">Добавить владельца</el-button>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { ElMessage } from 'element-plus'

// Mock data - in real app, this would come from API
const spots = ref([
  { id: 1, number: 'A1', occupied: false },
  { id: 2, number: 'A2', occupied: true }
])

const cars = ref([
  { id: 1, licensePlate: 'ABC123', owner: { name: 'Иванов Иван' } },
  { id: 2, licensePlate: 'DEF456', owner: { name: 'Петров Петр' } }
])

const owners = ref([
  { id: 1, name: 'Иванов Иван', phone: '+7 123 456 7890' },
  { id: 2, name: 'Петров Петр', phone: '+7 987 654 3210' }
])

const activeTab = ref('spots')
const carSearch = ref('')
const ownerSearch = ref('')

const filteredCars = computed(() => {
  return cars.value.filter(car => car.licensePlate.toLowerCase().includes(carSearch.value.toLowerCase()))
})

const filteredOwners = computed(() => {
  return owners.value.filter(owner => owner.name.toLowerCase().includes(ownerSearch.value.toLowerCase()))
})

const handleTabClick = (tab: any) => {
  console.log(tab.props.name)
}

const addSpot = () => {
  // TODO: Open dialog to add spot
  ElMessage.info('Функция добавления места в разработке')
}

const editSpot = (spot: any) => {
  // TODO: Open dialog to edit spot
  ElMessage.info('Функция редактирования места в разработке')
}

const deleteSpot = (spot: any) => {
  // TODO: Delete spot
  ElMessage.info('Функция удаления места в разработке')
}

const addCar = () => {
  // TODO: Open dialog to add car
  ElMessage.info('Функция добавления автомобиля в разработке')
}

const editCar = (car: any) => {
  // TODO: Open dialog to edit car
  ElMessage.info('Функция редактирования автомобиля в разработке')
}

const deleteCar = (car: any) => {
  // TODO: Delete car
  ElMessage.info('Функция удаления автомобиля в разработке')
}

const addOwner = () => {
  // TODO: Open dialog to add owner
  ElMessage.info('Функция добавления владельца в разработке')
}

const editOwner = (owner: any) => {
  // TODO: Open dialog to edit owner
  ElMessage.info('Функция редактирования владельца в разработке')
}

const deleteOwner = (owner: any) => {
  // TODO: Delete owner
  ElMessage.info('Функция удаления владельца в разработке')
}
</script>
