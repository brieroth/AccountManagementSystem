<template>
  <div class="container">
  <meta charset="UTF-8">
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Account Information
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
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
  <div class="container">
  <meta charset="UTF-8">
  <table class="table">
    <thead>
      <tr>
        <th>id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Account Number</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
       <tr v-for="row in rows" :key="row-id">
       <td>{{row.id}}</td>
       <td>{{row.firstname}}</td>
       <td>{{row.surname}}</td>
       <td>{{row.accountNumber}}</td>
       <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" @click="updateAPI(row)" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
       <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" @click="deletefromAPI(row, row.id) " data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
      </tr>
     </tbody>
   </table>
 </div>
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
      rows: []      
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
      axios.post('/Account/',{
        firstname: this.Account.firstname,
        surname: this.Account.surname,
        accountNumber: this.Account.accountNumber
      })   
      },
    getfromAPI() {
      axios.get(`/Account/`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.rows = response.data
          console.log(response.data)
          this.httpStatusCode = response.status
          this.httpStatusText = response.statusText
          this.headers = response.headers
          this.fullResponse = response
        })
        .catch(e => {
          this.errors.push(e)
        })
    },
    deletefromAPI(rows, id){
      axios.delete('/Account/'+ id )
      .then(response => {
       this.rows = response.data
       console.log(response.data)
        })
    },
    updateAPI(rows) { 
        axios.put('/Account/' + id ,{
          body: JSON.stringify(row)      
      })}

    }
 }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
