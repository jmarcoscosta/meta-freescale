# Copyright (C) 2015-2016 Freescale Semiconductor
# Copyright (C) 2017-2021 NXP

SUMMARY = "Kernel loadable module for Vivante GPU"
DESCRIPTION = "Builds the Vivante GPU kernel driver as a loadable kernel module, \
allowing flexibility to use a newer graphics release with an older kernel."
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "${KERNEL_SRC};subpath=drivers/mxc/gpu-viv;destsuffix=git/src \
           file://Add-makefile.patch"
KERNEL_SRC ?= "git://github.com/nxp-imx/linux-imx.git;protocol=https;branch=${SRCBRANCH}"
SRCBRANCH = "lf-6.1.y"
LOCALVERSION = "-6.1.36-2.1.0"
SRCREV = "dde879f98b8273df392954b1e270360b33328ec1"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE += "CONFIG_MXC_GPU_VIV=m"

KERNEL_MODULE_AUTOLOAD = "galcore"
COMPATIBLE_MACHINE = "(imx-nxp-bsp)"
