<template>

  <div class="container">
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Account Information
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Get Accounts</a>
  </div>
</div>
  <form>
        <div class="well">
        <h4> Add User</h4>
        <div class="form-group">
          <label class="pull-left"> First Name </label>
          <input type="text" class="form-control" placeholder="First Name" v-model="Account.firstname">
        </div>
        <div class="form-group">
          <label class="pull-left"> Last Name </label>
          <input type="text" class="form-control" placeholder="Last Name" v-model="Account.surname">
        </div>
        <div class="form-group">
          <label class="pull-left"> Account Number </label>
          <input type="text" class="form-control" placeholder="Account Number" v-model="Account.accountNumber">
        </div>
      </div>
      <button type="submit" class="btn btn-large btn-block btn-primary full-width" @click ="sendtoAPI">Submit</button>
      <button type="submit" class="btn btn-large btn-block btn-primary full-width" @click ="getfromAPI">GetUsers</button>
    </form>
  </div>
</template>

<script>
/* eslint-disable */
 import axios from 'axios'

  export default {
    name: 'Add',
       data () {
     return {
      Account: { firstname:'',surname:'',accountNumber:'' },
      //myJson = JSON.stringify(Account)
        }
  },
   methods: {
    sendtoAPI() {
      let newAccount = {
        firstname: this.Account.firstname,
        surname: this.Account.surname,
        accountNumber: this.Account.accountNumber,
      }
      console.log(newAccount);
      axios.post('http://localhost:8080/Account/')
      .then((response) => {
           console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
      },
    getfromAPI() {
      axios.get(`http://localhost:8080/Account/`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.response = response.data
          console.log(response.data)
          this.httpStatusCode = response.status
          this.httpStatusText = response.statusText
          this.headers = response.headers
          this.fullResponse = response
        })
        .catch(e => {
          this.errors.push(e)
        })
    }

    }
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
