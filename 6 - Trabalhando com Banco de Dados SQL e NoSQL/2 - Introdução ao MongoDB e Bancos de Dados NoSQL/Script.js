db.getCollection("restaurants").find({})
db.getCollection("restaurants").count({})
db.getCollection("restaurants").distinct("cuisine")
db.getCollection("restaurants").aggregate([{$group: {_id: "$cuisine", total: {$sum: 1}}}])
db.getCollection("restaurants").aggregate([{$addFields: {"teste": true}}]) // campo "teste" adicionado apenas na agregação
db.getCollection("restaurants").aggregate([{$group: {_id: "$cuisine", total: {$sum: 1}, id_maximo: {$max: "$restaurant_id"}}}])
db.getCollection("restaurants").aggregate([{$group: {_id: "$cuisine", total: {$sum: 1}, id_maximo: {$min: "$restaurant_id"}}}])
// db.getCollection("restaurants").aggregate([{$group: {_id: "$cuisine", total: {$sum: 1}, id_maximo: {$avg: "$restaurant_id"}}}])
db.getCollection("restaurants").aggregate([{$match: {$or: [{cuisine: "American"}, {borough: "Brooklyn"}]}}])