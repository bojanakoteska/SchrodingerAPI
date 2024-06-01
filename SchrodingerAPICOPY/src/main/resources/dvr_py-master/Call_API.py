import json
import requests
response = requests.get('http://localhost:8080/3dHermiteMorse?npts=10&D1=3.0&a1=0.5&D2=3&a2=0.5&D3=3.0&a3=0.5&x0=0.0&y0=0.0&z0=0&prec=10')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")