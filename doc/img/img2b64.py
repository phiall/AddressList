#!/bin/python
import base64
import sys

if len(sys.argv) < 2:
    print 'usage: python img2b64.py pic_file_name'
f = open(sys.argv[1], 'rb')
print base64.b64encode(f.read())
f.close()
