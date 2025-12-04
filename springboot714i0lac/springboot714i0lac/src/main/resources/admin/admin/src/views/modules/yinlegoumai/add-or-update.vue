<template>
	<div class="addEdit-block" :style='{"padding":"20px 30px 30px","margin":"0 auto","color":"#666","borderRadius":"0 0 10px 10px","background":"#fff","width":"calc(100% - 60px)","fontSize":"16px"}'>
		<el-form
			:style='{"border":"0px solid rgba(254,169,35,.2)","padding":"30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","fontSize":"inherit","borderRadius":"4px","background":"none"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'" label="订单编号" prop="dingdanbianhao">
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-else-if="ruleForm.dingdanbianhao" label="订单编号" prop="dingdanbianhao">
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="歌名" prop="songname">
					<el-input v-model="ruleForm.songname" placeholder="歌名" clearable  :readonly="ro.songname"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="歌名" prop="songname">
					<el-input v-model="ruleForm.songname" placeholder="歌名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="歌曲分类" prop="gequfenlei">
					<el-input v-model="ruleForm.gequfenlei" placeholder="歌曲分类" clearable  :readonly="ro.gequfenlei"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="歌曲分类" prop="gequfenlei">
					<el-input v-model="ruleForm.gequfenlei" placeholder="歌曲分类" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="upload" v-if="type!='info' && !ro.fengmian" label="封面" prop="fengmian">
					<file-upload
						tip="点击上传封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
						@change="fengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="upload" v-else-if="ruleForm.fengmian" label="封面" prop="fengmian">
					<img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="歌手" prop="singer">
					<el-input v-model="ruleForm.singer" placeholder="歌手" clearable  :readonly="ro.singer"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="歌手" prop="singer">
					<el-input v-model="ruleForm.singer" placeholder="歌手" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="语言" prop="yuyan">
					<el-input v-model="ruleForm.yuyan" placeholder="语言" clearable  :readonly="ro.yuyan"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="语言" prop="yuyan">
					<el-input v-model="ruleForm.yuyan" placeholder="语言" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="专辑" prop="zhuanji">
					<el-input v-model="ruleForm.zhuanji" placeholder="专辑" clearable  :readonly="ro.zhuanji"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="专辑" prop="zhuanji">
					<el-input v-model="ruleForm.zhuanji" placeholder="专辑" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="价格" prop="jiage">
					<el-input-number v-model="ruleForm.jiage" placeholder="价格" :disabled="ro.jiage"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="价格" prop="jiage">
					<el-input v-model="ruleForm.jiage" placeholder="价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="date" v-if="type!='info'" label="购买时间" prop="goumaishijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.goumaishijian" 
						type="datetime"
						:readonly="ro.goumaishijian"
						placeholder="购买时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-else-if="ruleForm.goumaishijian" label="购买时间" prop="goumaishijian">
					<el-input v-model="ruleForm.goumaishijian" placeholder="购买时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming" placeholder="用户名" clearable  :readonly="ro.yonghuming"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming" placeholder="用户名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"color":"inherit","margin":"0 0 20px 0","fontSize":"inherit"}' v-else class="input" label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"0","margin":"30px 0 0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","fontSize":"48px","justifyContent":"center"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					保存
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
import { 
	isNumber,
} from "@/utils/validate";
export default {
	data() {
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				dingdanbianhao : false,
				songname : false,
				gequfenlei : false,
				fengmian : false,
				singer : false,
				yuyan : false,
				zhuanji : false,
				jiage : false,
				goumaishijian : false,
				yonghuming : false,
				xingming : false,
				crossuserid : false,
				crossrefid : false,
				ispay : false,
			},
			
			
			ruleForm: {
				dingdanbianhao: this.getUUID(),
				songname: '',
				gequfenlei: '',
				fengmian: '',
				singer: '',
				yuyan: '',
				zhuanji: '',
				jiage: '',
				goumaishijian: '',
				yonghuming: '',
				xingming: '',
				crossuserid: '',
				crossrefid: '',
			},
		

			
			rules: {
				dingdanbianhao: [
				],
				songname: [
				],
				gequfenlei: [
				],
				fengmian: [
				],
				singer: [
				],
				yuyan: [
				],
				zhuanji: [
				],
				jiage: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				goumaishijian: [
				],
				yonghuming: [
				],
				xingming: [
				],
				crossuserid: [
				],
				crossrefid: [
				],
				ispay: [
				],
			},
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.goumaishijian = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='dingdanbianhao'){
							this.ruleForm.dingdanbianhao = obj[o];
							this.ro.dingdanbianhao = true;
							continue;
						}
						if(o=='songname'){
							this.ruleForm.songname = obj[o];
							this.ro.songname = true;
							continue;
						}
						if(o=='gequfenlei'){
							this.ruleForm.gequfenlei = obj[o];
							this.ro.gequfenlei = true;
							continue;
						}
						if(o=='fengmian'){
							this.ruleForm.fengmian = obj[o];
							this.ro.fengmian = true;
							continue;
						}
						if(o=='singer'){
							this.ruleForm.singer = obj[o];
							this.ro.singer = true;
							continue;
						}
						if(o=='yuyan'){
							this.ruleForm.yuyan = obj[o];
							this.ro.yuyan = true;
							continue;
						}
						if(o=='zhuanji'){
							this.ruleForm.zhuanji = obj[o];
							this.ro.zhuanji = true;
							continue;
						}
						if(o=='jiage'){
							this.ruleForm.jiage = obj[o];
							this.ro.jiage = true;
							continue;
						}
						if(o=='goumaishijian'){
							this.ruleForm.goumaishijian = obj[o];
							this.ro.goumaishijian = true;
							continue;
						}
						if(o=='yonghuming'){
							this.ruleForm.yonghuming = obj[o];
							this.ro.yonghuming = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='crossuserid'){
							this.ruleForm.crossuserid = obj[o];
							this.ro.crossuserid = true;
							continue;
						}
						if(o=='crossrefid'){
							this.ruleForm.crossrefid = obj[o];
							this.ro.crossrefid = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.dingdanbianhao = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.songname = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.gequfenlei = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.fengmian = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.singer = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.yuyan = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.zhuanji = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.jiage = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.goumaishijian = true;
					}
					if(((json.yonghuming!=''&&json.yonghuming) || json.yonghuming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuming = json.yonghuming
						this.ro.yonghuming = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.yonghuming = true;
					}
					if(((json.xingming!=''&&json.xingming) || json.xingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xingming = json.xingming
						this.ro.xingming = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.xingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
		},
    // 多级联动参数

		info(id) {
			this.$http({
				url: `yinlegoumai/info/${id}`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.ruleForm = data.data;
					//解决前台上传图片后台不显示的问题
					let reg=new RegExp('../../../upload','g')//g代表全部
				} else {
					this.$message.error(data.msg);
				}
			});
		},


    // 提交
    onSubmit() {
		this.ruleForm.ispay = '未支付'
		if(this.ruleForm.dingdanbianhao) {
			this.ruleForm.dingdanbianhao = String(this.ruleForm.dingdanbianhao)
		}
	if(this.ruleForm.fengmian!=null) {
		this.ruleForm.fengmian = this.ruleForm.fengmian.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "yinlegoumai/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `yinlegoumai/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.yinlegoumaiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `yinlegoumai/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.yinlegoumaiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
		});
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yinlegoumaiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fengmianUploadChange(fileUrls) {
	    this.ruleForm.fengmian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: inherit;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  height: 44px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  height: 44px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 44px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 44px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid rgba(19,161,230,.2);
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 500px;
	  	  font-size: 16px;
	  	  height: 140px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 1px solid rgba(19,161,230,.2);
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 4px;
				color: rgba(19,161,230,.8);
				display: inline-block;
				font-size: 16px;
				line-height: 24px;
				border-radius: 4px;
				outline: none;
				background: rgba(255,255,255,1);
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				border: 1px solid #999;
				color: #333;
				background: rgba(255,255,255,1);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 1px solid rgba(19,161,230,.2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: rgba(19,161,230,.8);
				background: #fff;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				border: 1px solid #999;
				color: #333;
				background: #fff;
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 1px solid rgba(19,161,230,.2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: rgba(19,161,230,.8);
				background: rgba(255,255,255,1);
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				border: 1px solid #999;
				color: #333;
				background: #fff;
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 1px solid rgba(19,161,230,.2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: rgba(19,161,230,.8);
				background: rgba(255,255,255,1);
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				border: 1px solid #999;
				color: #333;
				background: #fff;
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 1px solid rgba(19,161,230,.2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 4px;
				outline: none;
				color: rgba(19,161,230,.8);
				background: rgba(255,255,255,1);
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				border: 1px solid #999;
				color: #333;
				background: #fff;
				opacity: 0.8;
			}
</style>
