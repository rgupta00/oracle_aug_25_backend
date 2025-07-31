var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var BookSchema = new Schema({
  title: String,
  author: String,
  category: String
});
//coding convension : books(collections)-> Book
//emps          Emp
module.exports = mongoose.model('Book', BookSchema);