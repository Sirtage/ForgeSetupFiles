#                               #
#   Forge Resource generator    #
#                 by Sirtage    #
#                               #
dlc=[]
import urllib.request
import json
try:
    import BlockStateLib
    dlc.append("BlockStateLib")
except:
    1
try:
    import JavaGen
    dlc.append("JavaGen")
except:
    1
import os
MOD_ID='sometest'
index={
    'dir_t': f"src/main/resources/assets/{MOD_ID}/textures/",
    'dir_lang': f"src/main/resources/assets/{MOD_ID}/lang/",
    'f_l': f"src/main/resources/assets/{MOD_ID}/lang/en_us.json",
    'dir_m': f"src/main/resources/assets/{MOD_ID}/models/",
    'dir_bs': f"src/main/resources/assets/{MOD_ID}/blockstates/",
    
    'dir_lt': f"src/main/resources/data/{MOD_ID}/loot_tables/",
    'dir_tag': f"src/main/resources/data/{MOD_ID}/tags/",
}

dir_dwl= "ForgeResGen/downloads/"

try:
    os.mkdir("ForgeResGen")
    os.mkdir("ForgeResGen/downloads")
except:
    1

def handJsonSetup(modid):
    try:
        with open("../../Desktop/test/ForgeResGen/item.json", 'w') as f:
            json.dump({"parent": "item/generated", "textures": {"layer0": f"{modid}:items/<texture id>"}}, f)
            f.close()
        print("Success.")
    except:
        print("One of stage has error.")


def mainSetup(modid):
    # ASSETS###
    try:
        os.mkdir("src/main/resources/assets")
        print("src/main/resources/assets created.")
    except:
        1
    try:
        os.mkdir(f"src/main/resources/assets/{modid}")
        print(f"src/main/resources/assets/{modid} created.")
    except:
        1

    # blockstates
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/blockstates")
        print(f"src/main/resources/assets/{modid}/blockstate created.")
    except:
        1

    # localisation files
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/lang")
        print(f"src/main/resources/assets/{modid}/lang created.")
    except:
        1
    if "en_us.json" not in os.listdir(f"src/main/resources/assets/{modid}/lang"):
        data = {}
        with open(f"src/main/resources/assets/{modid}/lang/en_us.json", 'w') as locf:
            json.dump(data, locf)
            locf.close()
        print(f"src/main/resources/assets/{modid}/lang/en_us.json created.")

    # models
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/models")
        print(f"src/main/resources/assets/{modid}/models created.")
    except:
        1
        # blocks
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/models/block")
        print(f"src/main/resources/assets/{modid}/models/block created.")
    except:
        1
        # items
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/models/item")
        print(f"src/main/resources/assets/{modid}/models/item created.")
    except:
        1

    # textures
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/textures")
        print(f"src/main/resources/assets/{modid}/textures created.")
    except:
        1
        # blocks
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/textures/blocks")
        print(f"src/main/resources/assets/{modid}/textures/block created.")
    except:
        1
        # items
    try:
        os.mkdir(f"src/main/resources/assets/{modid}/textures/items")
        print(f"src/main/resources/assets/{modid}/textures/items created.")
    except:
        1

    # DATA###
    try:
        os.mkdir("src/main/resources/data")
        print("src/main/resources/data created.")
    except:
        1
    try:
        os.mkdir(f"src/main/resources/data/{modid}")
        print(f"src/main/resources/data/{modid} created.")
    except:
        1
    # loot_tables
    try:
        os.mkdir(f"src/main/resources/data/{modid}/loot_tables")
        print(f"src/main/resources/data/{modid}/loot_tables created.")
    except:
        1
        # blocks
    try:
        os.mkdir(f"src/main/resources/data/{modid}/loot_tables/blocks")
        print(f"src/main/resources/data/{modid}/loot_tables/blocks created.")
    except:
        1

    # recipes
    try:
        os.mkdir(f"src/main/resources/data/{modid}/recipes")
        print(f"src/main/resources/data/{modid}/recipes created.")
    except:
        1

    # tags
    try:
        os.mkdir(f"src/main/resources/data/{modid}/tags")
        print(f"src/main/resources/data/{modid}/tags created.")
    except:
        1
        # blocks
    try:
        os.mkdir(f"src/main/resources/data/{modid}/tags/blocks")
        print(f"src/main/resources/data/{modid}/tags/blocks created.")
    except:
        1
        # items
    try:
        os.mkdir(f"src/main/resources/data/{modid}/tags/items")
        print(f"src/main/resources/data/{modid}/tags/items created.")
    except:
        1

def forgeSetup():
    # tags
    try:
        os.mkdir(f"src/main/resources/data/forge/tags")
        print(f"src/main/resources/data/forge/tags created.")
    except:
        1


def downloadMainFiles():
    f = urllib.request\
        .urlopen("https://raw.githubusercontent.com/Sirtage/ForgeSetupFiles/main/Register.java")
    with open(dir_dwl+"Register.java", 'w') as fl:
        fl.write(f.read().decode("utf-8"))


def createItem(modid, eid, name):
    # item_model
    try:
        mdl = open(index['dir_m'] + f"item/{eid}.json", 'w')
        dat = {
            "parent": "item/generated",
            "textures": {
                "layer0": f"{modid}:items/{eid}"
            }
        }
        json.dump(dat, mdl)
        mdl.close()
        print("Success: item model file setup completed.")
    except:
        print("Error: item model file setup failed.")
    # item_lang
    try:
        lang = open(index['f_l'], 'r')
        dat = json.load(lang)
        dat[f"item.{modid}.{eid}"] = name
        lang.close()
        lang = open(index['f_l'], 'w')
        json.dump(dat, lang)
        lang.close()
        print("Success: item localisation successfully added.")
    except:
        print("Error: item localisation add failed.")


def createSimpleBlock(modid, eid, name, mm):
    # block_model
    try:
        mdl = open(index['dir_m'] + f"block/{eid}.json", 'w')
        dat={}
        if mm=='all':
            dat = {
                "parent": "block/cube_all",
                "textures": {
                    "all": f"{modid}:blocks/{eid}"
                }
            }
        elif mm=='sided' or mm=='rotate':
            dat = {
              "parent": "minecraft:block/cube",
              "textures": {
                  "up": f"{modid}:blocks/{eid}",
                  "down": f"{modid}:blocks/{eid}",
                  "east": f"{modid}:blocks/{eid}",
                  "west": f"{modid}:blocks/{eid}",
                  "south": f"{modid}:blocks/{eid}",
                  "north": f"{modid}:blocks/{eid}"
              }
            }
        else:
            print("Canceled: Invalid model type.")
            mdl.close()
            return
        json.dump(dat, mdl)
        mdl.close()
        print("Success: block model file setup completed.")
    except:
        print("Error: block model file setup failed.")
    # block_item_model
    try:
        bmdl = open(index['dir_m'] + f"item/{eid}.json", 'w')
        dat = {
            "parent": f"{modid}:block/{eid}",
        }
        json.dump(dat, bmdl)
        bmdl.close()
        print("Success: block item model file setup completed.")
    except:
        print("Error: block item model file setup failed.")
    # blockstate
    try:
        bstate = open(index['dir_bs'] + f"{eid}.json", 'w')
        if mm=='rotate':
            dat = {
                "variants": {
                    "facing=east": {"model": f"{modid}:block/{eid}", "y": 90},
                    "facing=west": {"model": f"{modid}:block/{eid}", "y": 270},
                    "facing=north": {"model": f"{modid}:block/{eid}"},
                    "facing=south": {"model": f"{modid}:block/{eid}", "y": 180}
                }
            }
        else:
            dat = {
                "variants": {
                    "": {"model": f"{modid}:block/{eid}"}
                }
            }
        json.dump(dat, bstate)
        bstate.close()
        print("Success: blockstate file setup completed.")
    except:
        print("Error: blockstate file setup failed.")
    # block loot table
    try:
        blt = open(index['dir_lt'] + f"blocks/{eid}.json", 'w')
        dat = {
            "type": "minecraft:block",
            "pools": [
                {
                    "rolls": 1,
                    "entries": [
                        {
                            "type": "minecraft:item",
                            "name": f"{modid}:{eid}"
                        }
                    ]
                }
            ]
        }
        json.dump(dat, blt)
        blt.close()
        print("Success: default block loot table file setup completed.")
    except:
        print("Error: default block loot table file setup failed.")
    # block_lang
    try:
        lang = open(index['f_l'], 'r')
        dat = json.load(lang)
        dat[f"block.{modid}.{eid}"] = name
        lang.close()
        lang = open(index['f_l'], 'w')
        json.dump(dat, lang)
        lang.close()
        print("Success: block localisation successfully added.")
    except:
        print("Error: block localisation add failed.")


def createTooltip(modid, eid, tt):
    try:
        lang = open(index['f_l'], 'r')
        dat = json.load(lang)
        dat[f"tooltip.{modid}.{eid}"] = tt
        lang.close()
        lang = open(index['f_l'], 'w')
        json.dump(dat, lang)
        lang.close()
        print("Success: tooltip successfully added.")
    except:
        print("Error: tooltip adding failed.")


def createTag(modid, type, tid):
    dat = {
        "replace": False,
        "values": [

        ]
    }
    if type == "block":
        try:
            with open(index['dir_tag'] + f"blocks/{tid}.json", 'w') as f:
                json.dump(dat, f)
                f.close()
            print("Success: block tag successfully added.")
        except:
            1
    elif type == "item":
        try:
            with open(index['dir_tag'] + f"items/{tid}.json", 'w') as f:
                json.dump(dat, f)
                f.close()
            print("Success: item tag successfully added.")
        except:
            1


def createStairsKit(modid, eid, name):
    stairs: BlockStateLib.Stairs = BlockStateLib.Stairs(index, modid, eid, name)

def createCrop(modid, eid, name, stages):
    crop: BlockStateLib.Crop = BlockStateLib.Crop(index, modid, eid, name, stages)

while True:
    print('0. setup(-1 for setup forge directory; -2 for download main files"Register, tagDeving")')
    print('  -3. create res for handworking.')
    print('1. res add item')
    print('2. res add block')
    if "BlockStateLib" in dlc:
        print("  21. res add stairs")
        print("  22. res add crop")
    print('3. add trans tooltip')
    print('4. add custom mod tag')
    if "JavaGen" in dlc:
        print("51. generate TileEntity preset.")
        print("52. generate Container preset.")
        print("53. generate ContainerScreen preset.")
    mode=int(input("mode: "))
    if mode==0:
        mainSetup(MOD_ID)
    elif mode==-1:
        forgeSetup()
    elif mode==-2:
        downloadMainFiles()
    elif mode==-3:
        handJsonSetup(MOD_ID)
    #item adder
    elif mode==1:
        eid = str(input('item id: '))
        name = str(input('item name: '))
        createItem(MOD_ID, eid, name)
    #block adder
        #simple
    elif mode==2:
        eid = str(input('block id: '))
        name = str(input('block name: '))
        mm = str(input('model type(all/sided/rotate): '))
        createSimpleBlock(MOD_ID, eid, name, mm)
    elif mode==21:
        if "BlockStateLib" in dlc:
            eid = str(input("stairs id: "))
            name = str(input("stairs name: "))
            createStairsKit(MOD_ID, eid, name)
        else:
            print("BlockStateLib required.")
    elif mode==22:
        if "BlockStateLib" in dlc:
            eid = str(input("crop id: "))
            name = str(input("crop name: "))
            stages = int(input("crop stage count: "))
            createCrop(MOD_ID, eid, name, stages)
        else:
            print("BlockStateLib required.")
    #tooltips adder
    elif mode==3:
        eid = str(input("tooltip id: "))
        tt = str(input("tooltip text: "))
        createTooltip(MOD_ID, eid, tt)
    #tag adder
    elif mode==4:
        type = str(input("tag type(block/item): "))
        tid = str(input("tag id: "))
        createTag(MOD_ID, type, tid)

    #JavaGen dlc
    elif mode==51:
        if "JavaGen" in dlc:
            JavaGen.create_tileentity()
        else:
            print("JavaGen required.")
    elif mode==52:
        if "JavaGen" in dlc:
            JavaGen.create_container()
        else:
            print("JavaGen required.")
    elif mode==53:
        if "JavaGen" in dlc:
            JavaGen.create_containerscreen()
        else:
            print("JavaGen required.")