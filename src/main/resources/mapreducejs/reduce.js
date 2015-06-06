function(key, values) {
  var sum1 = 1, sum2 = 0;

  values.forEach(function (doc) {
    sum1 += key;
    sum2 += parseInt(doc);
  });

  return sum2/sum1;
}