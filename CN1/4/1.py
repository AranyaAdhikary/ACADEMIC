ip_address = input("Enter I.P. Address : ")
ip = ip_address.split('.')
for i in ip:
    if int(i) < 0 or int(i) > 255 : 
        print ("Invalid IP address")
        exit
if 0<=int(ip[0])<=127:
    print("Class = A")
    print("Net Id = "+ip[0])
    print("Host Id = "+ip[1]+'.'+ip[2]+'.'+ip[3])
elif 128<=int(ip[0])<=191:
    print("Class = B")
    print("Net Id = "+ip[0]+'.'+ip[1])
    print("Host Id = "+ip[2]+'.'+ip[3])
elif 192<=int(ip[0])<=223:
    print("Class = C")
    print("Net Id = "+ip[0]+'.'+ip[1]+'.'+ip[2])
    print("Host Id = "+ip[3])
elif 224<=int(ip[0])<=239:
    print("Class = D")
    print("Net Id = "+ ip_address)
elif 240<=int(ip[0])<=255:
    print("Class = E")
    print("Net Id = "+ ip_address)
