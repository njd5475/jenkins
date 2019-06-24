#!/bin/bash

ALL_PROPS=`find . -name "Messages_*.properties" -printf "%f\n" | sort | uniq`

for PROP_FILE in $ALL_PROPS
do
  cat `find . -name $PROP_FILE` > ALL_$PROP_FILE
done
