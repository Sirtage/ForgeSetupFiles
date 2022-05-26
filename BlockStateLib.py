import json

class Stairs:
    def __init__(self, index, modid, id, name):
        try:
            with open(index['dir_bs']+f"{id}.json", 'w') as f:
                json.dump(Stairs.generateBlockstate(modid, id), f)
                f.close()
            print("Success: blockstate file setup completed.")
        except:
            print("Error: blockstate file setup failed.")
        try:
            with open(index['dir_m']+f"block/{id}.json", 'w') as f:
                json.dump(Stairs.generateStairsModel(modid, id, "normal"), f)
                f.close()
            print("Success: block model file 1 setup completed.")
        except:
            print("Error: block model file 1 setup failed.")
        try:
            with open(index['dir_m']+f"block/{id}_inner.json", 'w') as f:
                json.dump(Stairs.generateStairsModel(modid, id, "inner"), f)
                f.close()
            print("Success: block model file 2 setup completed.")
        except:
            print("Error: block model file 2 setup failed.")
        try:
            with open(index['dir_m']+f"block/{id}_outer.json", 'w') as f:
                json.dump(Stairs.generateStairsModel(modid, id, "outer"), f)
                f.close()
            print("Success: block model file 3 setup completed.")
        except:
            print("Error: block model file 3 setup failed.")
        try:
            with open(index['dir_m']+f"item/{id}.json", 'w') as f:
                dat={"parent": f"{modid}:block/{id}"}
                json.dump(dat, f)
                f.close()
            print("Success: block item model setup completed.")
        except:
            print("Error: block item model setup failed.")
        try:
            lang = open(index['f_l'], 'r')
            dat = json.load(lang)
            dat[f"block.{modid}.{id}"] = name
            lang.close()
            lang = open(index['f_l'], 'w')
            json.dump(dat, lang)
            lang.close()
            print("Success: block localisation successfully added.")
        except:
            print("Error: block localisation add failed.")



    def generateStairsModel(modid, id, mode):
        stairs_model = {
            "textures": {
                "bottom": f"{modid}:blocks/{id}",
                "top": f"{modid}:blocks/{id}",
                "side": f"{modid}:blocks/{id}"
            }
        }
        if mode=="normal":
            stairs_model["parent"]= "minecraft:block/stairs"
        elif mode=="inner":
            stairs_model["parent"] = "minecraft:block/inner_stairs"
        elif mode=="outer":
            stairs_model["parent"] = "minecraft:block/outer_stairs"
        return stairs_model

    def generateBlockstate(modid, block_id):
        dat={
            "variants": {
                "facing=east,half=bottom,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}",
                    "y": 270,
                    "uvlock": True
                },
                "facing=east,half=bottom,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner"
                },
                "facing=east,half=bottom,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "y": 270,
                    "uvlock": True
                },
                "facing=east,half=bottom,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer"
                },
                "facing=east,half=bottom,shape=straight": {
                    "model": f"{modid}:block/{block_id}"
                },
                "facing=east,half=top,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "uvlock": True
                },
                "facing=east,half=top,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "y": 90,
                    "uvlock": True
                },
                "facing=east,half=top,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "uvlock": True
                },
                "facing=east,half=top,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "y": 90,
                    "uvlock": True
                },
                "facing=east,half=top,shape=straight": {
                    "model": f"{modid}:block/{block_id}",
                    "x": 180,
                    "uvlock": True
                },
                "facing=north,half=bottom,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "y": 180,
                    "uvlock": True
                },
                "facing=north,half=bottom,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "y": 270,
                    "uvlock": True
                },
                "facing=north,half=bottom,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "y": 180,
                    "uvlock": True
                },
                "facing=north,half=bottom,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "y": 270,
                    "uvlock": True
                },
                "facing=north,half=bottom,shape=straight": {
                    "model": f"{modid}:block/{block_id}",
                    "y": 270,
                    "uvlock": True
                },
                "facing=north,half=top,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "y": 270,
                    "uvlock": True
                },
                "facing=north,half=top,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "uvlock": True
                },
                "facing=north,half=top,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "y": 270,
                    "uvlock": True
                },
                "facing=north,half=top,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "uvlock": True
                },
                "facing=north,half=top,shape=straight": {
                    "model": f"{modid}:block/{block_id}",
                    "x": 180,
                    "y": 270,
                    "uvlock": True
                },
                "facing=south,half=bottom,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}_inner"
                },
                "facing=south,half=bottom,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "y": 90,
                    "uvlock": True
                },
                "facing=south,half=bottom,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer"
                },
                "facing=south,half=bottom,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "y": 90,
                    "uvlock": True
                },
                "facing=south,half=bottom,shape=straight": {
                    "model": f"{modid}:block/{block_id}",
                    "y": 90,
                    "uvlock": True
                },
                "facing=south,half=top,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "y": 90,
                    "uvlock": True
                },
                "facing=south,half=top,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "y": 180,
                    "uvlock": True
                },
                "facing=south,half=top,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "y": 90,
                    "uvlock": True
                },
                "facing=south,half=top,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "y": 180,
                    "uvlock": True
                },
                "facing=south,half=top,shape=straight": {
                    "model": f"{modid}:block/{block_id}",
                    "x": 180,
                    "y": 90,
                    "uvlock": True
                },
                "facing=west,half=bottom,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "y": 90,
                    "uvlock": True
                },
                "facing=west,half=bottom,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "y": 180,
                    "uvlock": True
                },
                "facing=west,half=bottom,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "y": 90,
                    "uvlock": True
                },
                "facing=west,half=bottom,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "y": 180,
                    "uvlock": True
                },
                "facing=west,half=bottom,shape=straight": {
                    "model": f"{modid}:block/{block_id}",
                    "y": 180,
                    "uvlock": True
                },
                "facing=west,half=top,shape=inner_left": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "y": 180,
                    "uvlock": True
                },
                "facing=west,half=top,shape=inner_right": {
                    "model": f"{modid}:block/{block_id}_inner",
                    "x": 180,
                    "y": 270,
                    "uvlock": True
                },
                "facing=west,half=top,shape=outer_left": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "y": 180,
                    "uvlock": True
                },
                "facing=west,half=top,shape=outer_right": {
                    "model": f"{modid}:block/{block_id}_outer",
                    "x": 180,
                    "y": 270,
                    "uvlock": True
                },
                "facing=west,half=top,shape=straight": {
                    "model": f"{modid}:block/{block_id}",
                    "x": 180,
                    "y": 180,
                    "uvlock": True
                }
            }
        }
        return dat

