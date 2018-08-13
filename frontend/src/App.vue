<template>
  <div id="app">
     <router-link :to="{name: 'HelloWorld' }">Add Accounts</router-link>
     <router-link to="/Accounts">View Accounts</router-link>
      <router-view/>
  </div>
</template>

<script>
/* eslint-disable */
import Accounts from './components/Accounts'
export default {
  name: 'App',
  components: {
    'Accounts': Accounts
  
  }
}
</script>

<style>

</style>
