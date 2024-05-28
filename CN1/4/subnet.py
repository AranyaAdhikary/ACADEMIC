def calculate_subnets(ip_cidr):
    network_address,subnet_bits = ip_cidr.split('/')
    print(f"Network Address: {network_address}")
    subnet_bits=int(subnet_bits)
    subnet = 32 - subnet_bits
    subnet_size = 2 ** subnet
    
    print(f"Size of Each Subnet: {subnet_size}")

    address = 8-subnet
    no_address_per_subnet = 2**(address)
    print(f"No of IP of Each Subnet: {no_address_per_subnet}")
    p=0
    for i in range(subnet_size):
       netid = str(network_address).rsplit('.',1)
       netid = netid[0]+'.'+str(p)
       print(f"Starting Network ID: {netid}")
       p = p+subnet_size
    
ip_cidr = "192.168.1.4/28"
calculate_subnets(ip_cidr)