import os

def get_sectors():
    sectors = []
    for fileName in os.listdir("../sectors"):
        print (fileName)

        with open("../sectors/" + fileName, "r") as file:
            for line in file:
                line = line.strip()
                if line == '' and line.startswith("Company"):
                    continue
                # print (line)
                arr = line.split(",")
                sector = {
                    "Company":  arr[0],  
                    "Industry": arr[1] , 
                    "Symbol": arr[2],
                    "Series" : arr[3],
                    "ISIN": arr[4],
                }

                sectors.append(sector)

    return sectors

# python, no main function
# to get main like
# ___name__ shall be main only when we run
# python sectors.py 
# if we import, __name__ shall not be __main__
if __name__ == '__main__':
    for sector in get_sectors():
        print (sector)

print("sectors.py __name__ is", __name__)