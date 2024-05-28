def mask(ip):
    if(ip >=0 and ip<=127):
        return [255,0,0,0]
    if(ip >=128 and ip<=191):
        return [255,255,0,0]
    if(ip >=192 and ip<=223):
        return [255,255,255,0]
    if(ip >=224 and ip<=255):
        return [0,0,0,0]
    else:
        return None
    
ip_address = input("Enter I.P. Address : ")
ip = ip_address.split('.')
for i in ip:
    if int(i) < 0 or int(i) > 255 : 
        print ("Invalid IP address")
        exit
ip = [int(i) for i in ip]
subnet = mask(ip[0])
if subnet == None:
    print("No valid subnet")
else:
    sub = [str(i) for i in subnet]
    print("Subnet mask :",'.'.join(sub))
    print(f'Subnet address : {ip[0]&subnet[0]}.{ip[1]&subnet[1]}.{ip[2]&subnet[2]}.{ip[3]&subnet[3]}')


    
