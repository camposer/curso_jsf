cat prueba.html | sed "s/\"/'/g" | awk -v _DQ='"' '{ print "pw.println(" _DQ $0 _DQ ");" }'
