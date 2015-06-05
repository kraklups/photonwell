var reduce = function(key, values) {
  var sum1 = 0, sum2 = 0;

  values.forEach(function (doc) {
    sum1 += doc.qty;
    sum2 += parseInt(doc.qtybs);
  });

  return {qty:sum1, qtybs:sum2};
}